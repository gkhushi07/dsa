class TrieNode:

    def __init__(self):
        self.children = {}
        self.is_end = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root

        for char in word:
            if char not in node.children: 
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end = True
    

    def delete(self, word):
        def _delete( current_node, word,depth):

            if len(word) == depth:
                if not current_node.is_end:
                    return False
                current_node.is_end = False
                return len(current_node.children) == 0 
        
            char = word[depth]
            if char not in current_node.children:
                return False
            
            should_delete_word = _delete( current_node.children[char], word,depth+1)

            if should_delete_word:
                del current_node.children[char]

                return len(current_node.children)==0 and not current_node.is_end
            
            return False
        _delete(self.root, word, 0)
    
    def display(self, node=None, word=""):
        if node is None:
            node = self.root
        if node.is_end:
            print(f"Word: {word}")
        for char, child_node in node.children.items():
            self.display(child_node, word + char)
    
    def erase(self, word):
        current_node = self.root
        current_node.prefix_count -= 1
        nodes = [current_node]
        
        for char in word:
            current_node = current_node.children[char]
            current_node.prefix_count -= 1
            nodes.append(current_node)
            
        nodes[-1].word_count -= 1
        if nodes[-1].word_count == 0:
            nodes[-1].is_end = False

# Example Usage
trie = Trie()
trie.insert("apple")
trie.insert("app")
trie.insert("cat")
trie.insert("cap")

print("Trie status after insertions:")
trie.display()

trie.delete("apple")

print("\nTrie status after deleting 'apple':")
trie.display()