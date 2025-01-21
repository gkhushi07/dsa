class TrieNode:
    def __init__(self, letter):
        self.letter = letter
        self.children = {}
        self.end_of_word = False
    
class Trie:
    def __init__(self):
        self.root = TrieNode("*")
    
    def insert(self, word):
        current_node = self.root
        for char in word:
            if char not in current_node.children:
                current_node.children[char] = TrieNode(char)
            current_node = current_node.children[char]
            current_node.end_of_word = True
    
    def search(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return node.end_of_word
    
    def check_prefix(self, word):
        node = self.root

        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return True

trie = Trie()
print(trie.insert("cat"))
print(trie.insert("cap"))
print(trie.insert("bat"))

print(trie.search("cat"))  
print(trie.search("can"))  
print("Check Prefix:", trie.check_prefix("ca"))
print("Check Prefix:", trie.check_prefix("xa"))

            

