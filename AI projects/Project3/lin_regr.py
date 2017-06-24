# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import csv
import random
import sys

__author__ = "Ishdavis"
__date__ = "$Nov 21, 2016 9:40:52 AM$"

def average_squared_error(w0,w1,vars):
    total = 0
    for x,y in vars:
        new_y = w0 + (w1 * x)
        error = y - new_y
        try:
            error = error **2
        except OverflowError:
            return False
        total += error
    return total / len(vars)
    
def find_model(filename,first,second, run_error):
    f = open(filename,"r+")
    train = csv.reader(f, delimiter=',')
    vars = []
    for line in train:
        line[first] = float(line[first])
        line[second] = float(line[second])
        vars.append((line[first],line[second]))
    print vars
    w0 = w1 = counter = 0
    alpha = .0001
    while True:
        delta0 = delta1 = 0
        counter += 1
        if counter % 5 == 0:
            print counter, " iterations:"
            print "Average squared error is:",average_squared_error(w0,w1,vars)
            print "Current model is: %f + %f * %f" %(w0,w1,x)
        for x,y in vars:
            x = float(x)
            y = float(y)
            line = w0 + (w1 * x)
            delta0 += y - line
            delta1 += ((y - line) * x)
        w0 = w0 + (alpha * delta0)
        w1 = w1 + (alpha * delta1)
        if abs(delta0) < .0005 and abs(delta1) < .0005:
            break
    print "\nResults, Part 1-------"
    print "w0 is", w0, ", w1 is", w1
    return w0, w1

def train_to_test(w0,w1,filename,first,second):
    f = open(filename,"r+")
    train = csv.reader(f, delimiter=',')
    vars = []
    for line in train:
        line[first] = float(line[first])
        line[second] = float(line[second])
        vars.append((line[first],line[second]))
    return average_squared_error(w0,w1,vars)

def train_to_test_multiple(w0,w1,filename,first,second,ops):
    f = open(filename,"r+")
    train = csv.reader(f, delimiter=',')
    vars = []
    for line in train:
        line[second] = float(line[second])
        line = [int(x) for x in line]
        vars.append((get_line_val(line,first,ops),line[second]))
    return average_squared_error(w0,w1,vars)
        
def shuffle_split_files():
    lines = open('part2.csv').readlines()
    random.shuffle(lines)
    print len(lines)
    open('part2train.csv', 'w').writelines(lines[0:314])
    open('part2test.csv', 'w').writelines(lines[314:len(lines)])
    
def get_line_val(line,indexes,ops):
    total = line[indexes[0]]
    counter = 1
    for op in ops:
        index1 = indexes[counter]
        if op == "+":
            total += line[index1]
        elif op == "-":
            total -= line[index1]
        elif op == "/":
            if line[index1] == 0:
                return False
            total /= line[index1]
        else:
            total *= line[index1]
        counter += 1
    return total
    
def find_model_multiple(filename,first,second, ops):
    f = open(filename,"r+")
    train = csv.reader(f, delimiter=',')
    vars = []
    for line in train:
        line[second] = float(line[second])
        line = [int(x) for x in line]
        temp = get_line_val(line,first,ops)
        if temp == False:
            return False,False
        vars.append((temp,line[second]))
    w0 = w1 = counter = 0
    alpha = .0001
    while True:
        delta0 = delta1 = 0
        counter += 1
        if counter % 5 == 0:
            #print counter, " iterations:"
            avg_error = average_squared_error(w0,w1,vars)
            if avg_error == False:
                return False, False
            #print "Average squared error is:",avg_error
            #print "Current model is: %f + %f * %f" %(w0,w1,x)
        for x,y in vars:
            x = float(x)
            y = float(y)
            line = w0 + (w1 * x)
            delta0 += y - line
            delta1 += ((y - line) * x)
        w0 = w0 + (alpha * delta0)
        w1 = w1 + (alpha * delta1)
        if abs(delta0) < .0005 and abs(delta1) < .0005:
            break
    #print "w0 is", w0, ", w1 is", w1
    return w0, w1

if __name__ == "__main__":
    w0, w1 = find_model("part1 train.csv",0,1, True)
    print "Averaged Squared error on test data:", train_to_test(w0,w1,"part1 test.csv",0,1)
    #shuffle_split_files() Shuffles and splits the files,shouldn't need to be run
    minimum = sys.maxint
    second = 13
    columns = [5,2,6]
    columns.append(100)
    operations = ['*','/','+','-']
    ops = ['*','+']
    ops.append('placeholder')
    column = -1
    new_op = 'placeholder'
    w0Orig = w1Orig = 0
    for i in range(0, 13):
        if i not in columns:
            columns[3] = i
            for rations in operations:
                ops[2] = rations
                w0,w1 = find_model_multiple("part2train.csv",columns,second,ops)
                if w0 == False and w1 == False:
                    value = float('inf')
                else:
                    value = train_to_test_multiple(w0,w1,"part2test.csv",columns,second,ops)
                if value < minimum:
                    minimum = value
                    column = i
                    new_op = rations
                    w0Orig = w0
                    w1Orig = w1
    print "\nResults, Part 2----------"
    columns[3] = column
    print "Columns used:",columns
    print "The average squared error is:",minimum
    print "w0 is %f & w1 is %f" % (w0Orig,w1Orig)
    
  
        
        
        
        
        
        
