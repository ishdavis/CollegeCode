# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "Ishdavis"
__date__ = "$Sep 18, 2016 10:16:39 PM$"
import os
import collections
import sys
import heapq
import re
import random
import math

frontier_max = 0
'''
Generate children for 3 jugs
'''
def add_children_jug3(curNode, explored = None):
    jug1 = curNode.jug1
    jug2 = curNode.jug2
    jug3 = curNode.jug3
    global MAX1
    global MAX2
    global MAX3
    if jug1 < MAX1:
        child = Water(MAX1,jug2,curNode,jug3)
        if explored != None:
            key = str(child.jug1) + str(child.jug2) + str(child.jug3)
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug2 < MAX2:
        child = Water(jug1,MAX2,curNode,jug3)
        if explored != None:
            key = str(child.jug1) + str(child.jug2) + str(child.jug3)
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug3 < MAX3:
        child = Water(jug1,jug2,curNode,MAX3)
        if explored != None:
            key = str(child.jug1) + str(child.jug2) + str(child.jug3)
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug1 > 0:
        child = Water(0,jug2,curNode,jug3)
        if explored != None:
            key = str(child.jug1) + str(child.jug2) + str(child.jug3)
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug2 > 0:
        child = Water(jug1,0,curNode,jug3)
        if explored != None:
            key = str(child.jug1) + str(child.jug2) + str(child.jug3)
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug3 > 0:
        child = Water(jug1,jug2,curNode,0)
        if explored != None:
            key = str(child.jug1) + str(child.jug2) + str(child.jug3)
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug1 < MAX1 and jug2 > 0:
        add_amount = jug1 + jug2
        if add_amount > MAX1:
            child = Water(MAX1, add_amount - MAX1, curNode, jug3)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(add_amount, 0, curNode, jug3)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    if jug1 < MAX1 and jug3 > 0:
        add_amount = jug1 + jug3
        if add_amount > MAX1:
            child = Water(MAX1, jug2, curNode, add_amount - MAX1)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(add_amount, jug2, curNode, 0)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    if jug2 < MAX2 and jug1 > 0:
        add_amount = jug1 + jug2
        if add_amount > MAX2:
            child = Water(add_amount - MAX2, MAX2, curNode, jug3)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(0, add_amount, curNode, jug3)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    if jug2 < MAX2 and jug3 > 0:
        add_amount = jug3 + jug2
        if add_amount > MAX2:
            child = Water(jug1, MAX2, curNode, add_amount - MAX2)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(jug1, add_amount, curNode, 0)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    if jug3 < MAX3 and jug1 > 0:
        add_amount = jug3 + jug1
        if add_amount > MAX3:
            child = Water(add_amount - MAX3, jug2, curNode, MAX3)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(0, jug2, curNode, add_amount)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    if jug3 < MAX3 and jug2 > 0:
        add_amount = jug3 + jug2
        if add_amount > MAX3:
            child = Water(jug1, add_amount - MAX3, curNode, MAX3)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(jug1, 0, curNode, add_amount)
            if explored != None:
                key = str(child.jug1) + str(child.jug2) + str(child.jug3)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    
'''
Generate children for two jugs
'''
def add_children_jug2(curNode, explored = None):
    jug1 = curNode.jug1
    jug2 = curNode.jug2
    global total_created
    global MAX1
    global MAX2
    if jug1 < MAX1:
        child = Water(MAX1,jug2,curNode)
        if explored != None:
            key = str(child.jug1) + str(child.jug2)
            #print key
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug2 < MAX2:
        child = Water(jug1,MAX2,curNode)
        if explored != None:
            key = str(child.jug1) + str(child.jug2)
            #print key
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug1 > 0:
        child = Water(0,jug2,curNode)
        if explored != None:
            key = str(child.jug1) + str(child.jug2)
            #print key
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug2 > 0:
        child = Water(jug1,0,curNode)
        if explored != None:
            key = str(child.jug1) + str(child.jug2)
            #print key
            if key not in explored:
                curNode.children.append(child)
                explored[key] = 1
        else:
            curNode.children.append(child)
    if jug1 < MAX1 and jug2 > 0:
        add_amount = jug1 + jug2
        if add_amount > MAX1:
            child = Water(MAX1, add_amount - MAX1, curNode)
            if explored != None:
                key = str(child.jug1) + str(child.jug2)
                #print key
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(add_amount, 0, curNode)
            if explored != None:
                key = str(child.jug1) + str(child.jug2)
                #print key
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
    if jug2 < MAX2 and jug1 > 0:
        add_amount = jug1 + jug2
        if add_amount > MAX2:
            child = Water(add_amount - MAX2, MAX2, curNode)
            if explored != None:
                key = str(child.jug1) + str(child.jug2)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)
        else:
            child = Water(0, add_amount, curNode)
            if explored != None:
                key = str(child.jug1) + str(child.jug2)
                if key not in explored:
                    curNode.children.append(child)
                    explored[key] = 1
            else:
                curNode.children.append(child)

'''
Goal test Jugs
'''
def goal_test(cur_node):
    if isinstance(cur_node, Water):
        global goal1
        global goal2
        global goal3
        if goal3 != -1:
            if cur_node.jug1 == goal1 and cur_node.jug2 == goal2 and cur_node.jug3 == goal3:
                return True
            else:
                return False
        else:
            if cur_node.jug1 == goal1 and cur_node.jug2 == goal2:
                return True
            else:
                return False
    elif isinstance(cur_node, City):
        global city_goal
        return 1 if cur_node.name == city_goal else 0
    else:
        global pancake_solution
        return 1 if cur_node.state == pancake_solution else 0
            
'''
Output path if solution is found
'''
def solution(cur_node):
    stack = []
    stack.append(cur_node)
    total_cost = 0
    printer = False
    while cur_node.parent != None:
        cur_node = cur_node.parent
        stack.append(cur_node)
    for node in reversed(stack):
        if isinstance(cur_node, City):#cities
            global cities
            if node.parent != None:
                total_cost += cities[node.name].child_keys[node.parent.name]
                print "%s -> %d" %(node.name, cities[node.name].child_keys[node.parent.name])
            else:
                print "%s -> %d" %(node.name, 0)
            printer = True
        elif isinstance(cur_node,Water):#jugs
            if node.is_2_jug():
                print "(%d,%d)" % (node.jug1, node.jug2)
            else:
                print "(%d,%d,%d)" % (node.jug1, node.jug2, node.jug3)
        else:
            print node.state
    if printer == True:
        print "Total cost is -> %d" % total_cost

'''
Solution for pancake problem
'''
def solution2(cur_node):
    stack = []
    stack.append(cur_node)
    total_cost = 0
    printer = False
    while cur_node.parent != None:
        cur_node = cur_node.parent
        stack.append(cur_node)
    for node in reversed(stack):
        print node.state


def Depth_Limited_Search(cur_node, depth):
    global total_created
    if goal_test(cur_node):
        print "Goal Met"
        print "Total nodes created: %d" % total_created
        print "Maximum nodes on explored: %d" % 0
        print "Maximum size of frontier: %d" % 0
        solution(cur_node)
        return 1
    elif depth == 0:
        return -1
    else:
        cutoff_occured = False
        cur_node.gen_children("DFS")
        for child in cur_node.children:
            total_created += 1
            result = Depth_Limited_Search(child, depth-1)
            if result == -1:
                cutoff_occured = True
            elif result != -1:
                return 1
        if cutoff_occured:
            return -1

'''
IDDFS
'''
def IDDFS(cur_node, depth):
    global total_created
    total_created = 1
    temp = cur_node
    for i in range(0, depth+1):
        cur_node = temp
        result = Depth_Limited_Search(cur_node, i)
        if result != -1:
            return
    print "No solution"

'''
DFS
'''
def DFS(cur_node):
    global total_created
    total_created = 1
    frontier_max = 1
    frontier = collections.deque()
    frontier.append(cur_node)
    while 1:
        if len(frontier) == 0:
            print "No solution"
            return False
        cur_node = frontier.pop()
        if goal_test(cur_node):
            print "Goal Met"
            print "Total nodes created: %d" % total_created
            print "Maximum nodes on explored: %d" % 0
            print "Maximum size of frontier: %d" % frontier_max
            print "Path"
            print "----"
            return solution2(cur_node) if isinstance(cur_node, pancake_stack) else solution(cur_node)
        for child in cur_node.children:
            total_created += 1
            if cur_node.parent == None or child.gen_key() != cur_node.parent.gen_key():
                frontier.append(child)
                child.parent = cur_node
        if len(frontier) > frontier_max:
                frontier_max = len(frontier) 

'''
IDAStar
'''
def IDAStar(cur_node, heuristic):
    global total_created
    global cities
    temp_node = cur_node
    total_created = 1
    threshold = cur_node.get_h()
    while 1:
        cur_node.children = []
        temp = IDASearch(cur_node, 0, threshold)
        if temp == 1:
            return
        if temp == sys.maxint:
            print "No solution"
            return False
        threshold = temp
'''
IDASearch
'''
def IDASearch(cur_node, g, threshold):
    global total_created
    global cities
    f = g + cur_node.get_h()
    if f > threshold:
        return f
    if goal_test(cur_node):
        print "Goal Met"
        print "Total nodes created: %d" % total_created
        print "Maximum nodes on explored: %d" % 0
        print "Maximum size of frontier: %d" % 0
        print "Path"
        print "----"
        solution2(cur_node) if isinstance(cur_node, pancake_stack) else solution(cur_node)
        return 1
    min = sys.maxint
    cur_node.gen_children()
    for child in cur_node.children:
        total_created += 1
        temp = IDASearch(child,g+child.get_cost(cur_node) ,threshold)
        if temp == 1:
            return 1
        if temp < min:
            min = temp
    return min

'''
AStar
'''
def AStar(cur_node, heuristic):
    global total_created
    global cities
    total_created = 1
    frontier_max = 1
    frontier = []
    heapq.heappush(frontier, (cur_node.get_h() + 0, cur_node, cur_node.gen_key()))
    explored = {}
    while 1:
        if len(frontier) == 0:
                print "No solution"
                return False
        val, cur_node, key = heapq.heappop(frontier)
        if goal_test(cur_node):
            print "Goal Met"
            print "Total nodes created: %d" % total_created
            print "Maximum nodes on explored: %d" % len(explored)
            print "Maximum size of frontier: %d" % frontier_max
            print "Path"
            print "----"
            return solution2(cur_node) if isinstance(cur_node, pancake_stack) else solution(cur_node)
        explored[key] = val
        cur_node.gen_children()
        for child in cur_node.children:
            total_created += 1
            path = 0
            if isinstance(cur_node,pancake_stack):
                path = child.get_h() + child.get_cost()
            else:
                path = val + child.get_cost(cur_node) + child.get_h()
            key = child.gen_key()
            if len(frontier) == 0:
                if key not in explored:
                    heapq.heappush(frontier, (path, child, key))
                    child.parent = cur_node
            elif key not in zip(*frontier)[2] and key not in explored:
                heapq.heappush(frontier, (path, child, key))
                child.parent = cur_node
            elif key in zip(*frontier)[2] and key not in explored:
                    index = zip(*frontier)[2].index(key)
                    if frontier[index][0] > path:
                        del frontier[index]
                        heapq.heappush(frontier, (path, child, key))
                        child.parent = cur_node
                        heapq.heapify(frontier)
            elif key in zip(*frontier)[2] and path < explored[key]:
                index = zip(*frontier)[2].index(key)
                del frontier[index]
                heapq.heappush(frontier, (path, child, cur_node))
                child.parent = cur_node
                heapq.heapify(frontier)
            l = 0
            if len(frontier) > frontier_max:
                frontier_max = len(frontier)

'''
Greedy
'''
def Greedy(cur_node, heuristic):
    global total_created
    global cities
    total_created = 1
    frontier_max = 1
    frontier = []
    heapq.heappush(frontier, (cur_node.get_h(), cur_node, cur_node.gen_key()))
    explored = {}
    while 1:
        if len(frontier) == 0:
                    print "No solution"
                    return False
        val, cur_node, key = heapq.heappop(frontier)
        if goal_test(cur_node):
                print "Goal Met"
                print "Total nodes created: %d" % total_created
                print "Maximum nodes on explored: %d" % len(explored)
                print "Maximum size of frontier: %d" % frontier_max
                print "Path"
                print "----"
                return solution2(cur_node) if isinstance(cur_node, pancake_stack) else solution(cur_node)
        explored[key] = val
        cur_node.gen_children()
        for child in cur_node.children:
            total_created += 1
            key = child.gen_key()
            path = child.get_h()
            if len(frontier) == 0:
                if key not in explored:
                    heapq.heappush(frontier, (path, child, key))
                    child.parent = cur_node
            elif key not in zip(*frontier)[2] and key not in explored:
                    heapq.heappush(frontier, (path, child, key))
                    child.parent = cur_node
            l = 0
            if len(frontier) > frontier_max:
                    frontier_max = len(frontier)
        
'''
Unicost
'''
def Unicost(cur_node):
    global total_created
    global cities
    total_created = 1
    frontier_max = 1
    frontier = []
    heapq.heappush(frontier, (0, cur_node, cur_node.gen_key()))
    explored = {}
    while 1:
        if len(frontier) == 0:
                print "No solution"
                return False
        val, cur_node, key = heapq.heappop(frontier)
        if goal_test(cur_node):
            print "Goal Met"
            print "Total nodes created: %d" % total_created
            print "Maximum nodes on explored: %d" % len(explored)
            print "Maximum size of frontier: %d" % frontier_max
            print "Path"
            print "----"
            return solution2(cur_node) if isinstance(cur_node, pancake_stack) else solution(cur_node)
        explored[key] = val
        cur_node.gen_children()
        for child in cur_node.children:
            total_created += 1
            path = val + child.get_cost(cur_node)
            key = child.gen_key()
            if len(frontier) == 0:
                if key not in explored:
                    heapq.heappush(frontier, (path, child, key))
                    child.parent = cur_node
            elif key not in zip(*frontier)[2] and key not in explored:
                heapq.heappush(frontier, (path, child, key))
                child.parent = cur_node
            elif key in zip(*frontier)[2] and key not in explored:
                    index = zip(*frontier)[2].index(key)
                    if frontier[index][0] > path:
                        del frontier[index]
                        heapq.heappush(frontier, (path, child, key))
                        child.parent = cur_node
                        heapq.heapify(frontier)
            elif key in zip(*frontier)[2] and path < explored[key]:
                index = zip(*frontier)[2].index(key)
                del frontier[index]
                heapq.heappush(frontier, (path, child, cur_node))
                child.parent = cur_node
                heapq.heapify(frontier)
            l = 0
            if len(frontier) > frontier_max:
                frontier_max = len(frontier)  

'''
Goal test city
'''
def goal_test_city(city, goal):
    return 1 if city.name == goal else 0
'''
BFS
'''

def BFS(cur_node):
    global total_created
    total_created = 1
    frontier_max = 1
    frontier = collections.deque()
    frontier.append(cur_node)
    explored = {}
    while 1:
        if len(frontier) == 0:
            print "No solution"
            return False
        cur_node = frontier.popleft()
        if goal_test(cur_node): #Need to abstract this
            print "Goal Met"
            print "Total nodes created: %d" % total_created
            print "Maximum nodes on explored: %d" % len(explored)
            print "Maximum size of frontier: %d" % frontier_max
            return solution2(cur_node) if isinstance(cur_node, pancake_stack) else solution(cur_node)
        explored[cur_node.gen_key()] = 1
        cur_node.gen_children(explored)
        for child in cur_node.children:
            if child.gen_key() not in explored:
                frontier.append(child)
                child.parent = cur_node
                total_created += 1
        if len(frontier) > frontier_max:
            frontier_max = len(frontier)


  
        
def gen_children_pancake(cur_state):
    for x in range(1,len(cur_state.state)+1):
        order = cur_state.state[:]
        order[0:x] = [-y for y in order[0:x]]
        order[0:x] = order[0:x][::-1]
        temp = pancake_stack(order)
        temp.parent = cur_state
        cur_state.children.append(temp)
        

class Water:
    def __init__(self,jug1,jug2,parent,jug3 = -1):
        self.jug1 = jug1
        self.jug2 = jug2
        self.parent = parent
        self.children = []
        self.jug3 = jug3
        self.path_cost = 1
    
    def is_2_jug(self):
        return True if self.jug3 == -1 else False
    
    def gen_key(self):
        if self.jug3 == -1:
            return str(self.jug1) + str(self.jug2)
        else:
            return str(self.jug1) + str(self.jug2) + str(self.jug3)
        
    def gen_children(self, explored = None):
        explored = None
        if self.jug3 == -1:
            add_children_jug2(self, explored)
        else:
            add_children_jug3(self, explored)
            
    def get_cost(self, name = ""):
        return 1
    
    def get_h(self):
        global goal1
        global goal2
        if self.jug3 == -1:
            global goal3
            return abs(self.jug1 - goal1) + abs(self.jug2 - goal2) + abs(self.jug3 - goal3)
        else:
            return abs(self.jug1 - goal1) + abs(self.jug2 - goal2)            

class pancake_stack:
    def __init__(self, state):
        self.state = state
        self.children = []
        self.parent = None
    
    def gen_key(self):
        key = ""
        for x in self.state:
            key +=str(x)
        return key
    
    def gen_children(self, explored = None):
        gen_children_pancake(self)
    
    def get_cost(self, name = ""):
        return 1
    
    def get_h(self):
        total = 0
        counter = 0
        for i in range(len(self.state), 1, -1):
            if self.state[i - 1] != i:
                total = i
                break
        for i in range(0, len(self.state), 1):
            if self.state[i] == total or self.state[i] == -total:
                break
            else:
                counter += 1
        return total * 30 + counter
            

class City:
    def __init__(self, name, parent, x, y):
        self.name = name
        self.child_keys = {}
        self.children = []
        self.parent = parent
        self.x = x
        self.y = y
        
    def gen_key(self):
        return self.name
    
    def gen_children(self, explored = None):
        global cities
        for item in self.child_keys.keys():
            if explored == "DFS":
                if self.parent == cities[item].parent and self.parent != None:#Just in case nodes are on same level, but one is child of the other
                    pass
                else:
                    self.children.append(cities[item])
            else:
                self.children.append(cities[item])
    
    def get_cost(self, node=""):
        global cities
        return cities[self.name].child_keys[node.name]
    
    def get_h(self):
        global city_goal   
        global cities
        goal = cities[city_goal]
        x_squared = (self.x - goal.x) ** 2
        y_squared = (self.y - goal.y) ** 2
        return math.sqrt(x_squared + y_squared)
        
def parse_command_line():
    file_name = sys.argv[1]
    search = sys.argv[2]
    if len(sys.argv) == 4:
        heuristic = sys.argv[3]
    else:
        heuristic = None
    return file_name, search, heuristic

def start_search(cur_node, search, heuristic, problem):
    search = search.lower()
    print "\nRunning %s on the %s problem" % (search, problem)
    if search == "bfs":
        BFS(cur_node)
    elif search == "dfs":
        DFS(cur_node)
    elif search == "iddfs":
        IDDFS(cur_node,100)
    elif search == "unicost":
        Unicost(cur_node)
    elif search == "greedy":
        Greedy(cur_node, heuristic)
    elif search == "astar":
        AStar(cur_node, heuristic)
    elif search == "idastar":
        IDAStar(cur_node, heuristic)
    else:
        print "Arg for search wasn't valid"
        sys.exit()

if __name__ == "__main__":
    arg_len = len(sys.argv)
    if arg_len < 2 or arg_len > 3:
        print "Not enough args"
        sys.exit()
    file_name, search, heuristic = parse_command_line()
    #sys.argv is list of command line args, parse these in a method
    f = open(file_name,"r+")
    for line in f:
        if line.startswith("j"):
            global MAX1
            global MAX2
            global goal1
            global goal2
            global MAX3
            global goal3
            MAX3 = -1
            goal3 = -1
            capacities = f.next()
            capacities = capacities.translate(None,"()\n")
            capacity_list = capacities.split(",")
            MAX1 = int(capacity_list[0])
            MAX2 = int(capacity_list[1])
            init_state = f.next()
            init_state = init_state.translate(None,"()\n")
            init_list = init_state.split(",")
            jug1 = int(init_list[0])
            jug2 = int(init_list[1])
            goal_state = f.next()
            goal_state = goal_state.translate(None,"()\n")
            goal_list = goal_state.split(",")
            goal1 = int(goal_list[0])
            goal2 = int(goal_list[1])
            cur_node = 0
            if len(init_list) == 2:
                cur_node = Water(jug1, jug2, None)
            else:#if this is a 3 jug problem
                MAX3 = int(capacity_list[2])
                jug3 = int(init_list[2])
                goal3 = int(goal_list[2])
                cur_node = Water(jug1, jug2, None, jug3)
            start_search(cur_node, search, heuristic, "jugs")
            break
        if line.startswith("c"):
            global city_goal
            global cities
            cities = f.next()
            city_list = cities.split("\"")
            #print city_list
            cities = {}
            for x in range(1, len(city_list),2):
                city_list[x] = re.sub("[^a-zA-Z0123456789]","", city_list[x])
                city_list[x+1] = re.sub("[^a-zA-Z0123456789]","", city_list[x+1])
                x_val = city_list[x+1][:1]
                y_val = city_list[x+1][1:2]
                if len(city_list[x]) > 0:
                    temp = City(city_list[x], None, int(x_val), int(y_val))
                    cities[city_list[x]] = temp
                cur = cities[city_list[x]]
            init = f.next()
            init = init.translate(None, "()\n\"")
            goal = f.next()
            city_goal = goal.translate(None, "\"\n")
            while 1:
                try:
                    routes = f.next()
                    if "(" in routes:
                        routes = routes.translate(None, "()\"\n ")
                        route_list = routes.split(",")
                        cities[route_list[0]].child_keys[route_list[1]] = int(route_list[2])
                        cities[route_list[1]].child_keys[route_list[0]] = int(route_list[2])
                except:
                    break
            start_search(cities[init], search, heuristic, "cities")
            break
        if line.startswith("p"):
            global pancake_solution
            problem = f.next()
            while ")" not in problem:
                problem += f.next()
            solution = f.next()
            while ")" not in solution:
                solution += f.next()
            problem = problem.translate(None, "()\n")
            solution = solution.translate(None, "()\n")
            solution = solution.split(",")
            init = problem.split(",")
            init = [int(x) for x in init]
            pancake_solution = [int(x) for x in solution]
            cur_node = pancake_stack(init)
            start_search(cur_node, search, heuristic, "pancakes")
            break
            