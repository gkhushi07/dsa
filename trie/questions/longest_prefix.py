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
        prefix = ""
        current_node = self.root

        while current_node:
            if len(current_node.children) == 1 and not current_node.is_end:
                first_key = None
                for key in current_node.children:
                    first_key = key
                    break
                prefix += first_key
                current_node = current_node.children[first_key]

            else:
                break
        
        return prefix
            

arr = ["car", "care", "caring", "cars"]

trie = Trie()
for word in arr:
    trie.insert(word)

longest_prefix = trie.find_longest_prefix()
print("longest_prefix:", longest_prefix )

