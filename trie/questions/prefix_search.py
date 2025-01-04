class Trie:
    def __init__(self):
        self.root = {"*": "*"}
    
    def insert_word(self, word):
        current_node = self.root

        for char in word: 
            if char not in current_node:
                current_node[char]= {}
            current_node = current_node[char]
        current_node["*"] = "*"

    def search_prefix(self, prefix):
        current_node = self.root

        for char in prefix:
            if char not in current_node:
                return False
            current_node = current_node[char]
        return True 

    def count_words_with_prefix(self, prefix):
        current_node = self.root

        for char in prefix:
            if char not in current_node:
                return 0
            current_node = current_node[char]
        return len([child for child in current_node])
trie = Trie()

print("Inserting CAT", trie.insert_word("CAT"))
print("Inserting CAP", trie.insert_word("CAP"))
print("Inserting CASER", trie.insert_word("CASER"))


print("Searching for CA", trie.search_prefix("CA"))
print("Searching for CAT", trie.search_prefix("CAT"))
print("Searching for CASPER", trie.search_prefix("CASPER"))
print("Searching for CATER", trie.search_prefix("CATER"))


print("Count of words with CA:", trie.count_words_with_prefix("CA"))