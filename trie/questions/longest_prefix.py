class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        current_node = self.root
        for char in word:
            if char not in current_node.children:
                current_node.children[char]= TrieNode()
            current_node = current_node.children[char]
        current_node.is_end  = True

    def find_longest_prefix(self):

