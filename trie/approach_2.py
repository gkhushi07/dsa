class Trie:

    def __init__(self):
        self.root = {"*": "*"}
    
    def insert(self, word):
        current_node = self.root
        for char in word: 
            if char not in current_node:
                current_node[char] = {}
            current_node = current_node[char]
        current_node["*"] = "*"
    
    def search(self, word):
        node = self.root

        for char in word:
            if char not in node:
                return False
            node = node[char]
        return "*" in node
    
def delete(self, word):
    def _delete(node, word, index):
        if index == len(word):
            if not node.end_of_word:
                return False  # Word not found
            node.end_of_word = False  # Unmark the end of the word
            return len(node.children) == 0  # Return True if this node has no children

        char = word[index]
        if char not in node.children:
            return False  # Word not found
        
        should_delete = _delete(node.children[char], word, index + 1)

        # If the child should be deleted, remove it from children
        if should_delete:
            del node.children[char]
            return len(node.children) == 0  # Return True if no children left
        
        return False

    _delete(self.root, word, 0)

trie = Trie()
print("Home", trie.insert("Home"))
print("Homestay", trie.insert("Homestay"))
print("Hostel", trie.insert("Hostel"))

print("Is Home Present? : ", trie.search("Home"))
print("Is Homestay Present? : ", trie.search("Homestay"))
print("Is Homieee Present? : ", trie.search("Homieee"))