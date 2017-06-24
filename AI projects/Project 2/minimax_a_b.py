# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "Ishdavis"
__date__ = "$Oct 8, 2016 1:50:20 PM$"

import ast
import sys

class Node:
    def __init__(self, name):
        self.children = []
        self.name = name
        
    def add_to_children(self, child):
        self.children.append(child)
    
    def __len__(self):
        return len(self.name)
    
    def get_children(self):
        return self.children

def add_children(root, tokens):
    if len(root) > 2:
        return
    for i in range(1,len(tokens),1):
        if type(tokens[i]) is tuple:
            root.add_to_children(tokens[i])
        else:
            tempy = Node(tokens[i][0])
            root.add_to_children(tempy)
            temp = ast.literal_eval(str(tokens[i]))
            add_children(tempy, temp)
        

def mini_max(root):
    v = max_value(root)
    print "Utility value for root: %d" % v
    
def max_value(node):
    if type(node) is tuple:
        print "Visited %s" % str(node)
        return node[1]
    else:
        v = float('-inf')
        for child in node.get_children():
            if type(child) is not tuple:
                print "Visited %s" % child.name
            v = max(v, min_value(child))
        return v
    
def min_value(node):
    if type(node) is tuple:
        print "Visited %s" % str(node)
        return node[1]
    else:
        v = float('inf')
        for child in node.get_children():
            if type(child) is not tuple:
                print "Visited %s" % str(child.name)
            v = min(v, max_value(child))
        return v
    
def alpha_beta(root):
    v = max_ab(root, float('-inf'), float('inf'))
    print "Utility value for root: %d" % v
    
def max_ab(node, alpha, beta):
    if type(node) is tuple:
        print "Visited %s" % str(node)
        return node[1]
    else:
        v = float('-inf')
        for child in node.get_children():
            if type(child) is not tuple:
                print "Visited %s" % child.name
            v = max(v, min_ab(child, alpha, beta))
            if v >= beta:
                return v
            else:
                alpha = max(alpha,v)
        return v
    
def min_ab(node, alpha, beta):
    if type(node) is tuple:
        print "Visited %s" % str(node)
        return node[1]
    else:
        v = float('inf')
        for child in node.get_children():
            if type(child) is not tuple:
                print "Visited %s" % child.name
            v = min(v, max_ab(child, alpha, beta))
            if v <= alpha:
                return v
            else:
                beta = min(beta,v)
        return v

def run_tests():
    files = ["test_tree1", "test_tree2", "test_tree3"]
    for file in files:
        f = open(file,"r+")
        tokens = ast.literal_eval(f.read())
        root = Node(tokens[0])
        print "--------------"
        print "Root is %s, without alpha-beta on file: %s" % (root.name, file)
        add_children(root,tokens)
        mini_max(root)
        root1 = Node(tokens[0])
        print "--------------"
        print "Root is %s, running alpha-beta on file: %s" % (root1.name, file)
        add_children(root1,tokens)
        alpha_beta(root1)
        f.close()
        

if __name__ == "__main__":
    run_tests()
            
    
