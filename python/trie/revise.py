class TrieNode:
    def __init__(self, letter):
        self.letter = letter
        self.children = {}
        self.end_of_word = False
        self.word_count = 0
        self.prefix_count = 0

class Trie:
    def __init__(self):
        self.root = TrieNode("*")
    
    def insert(self, word):
        current_node = self.root
        for char in word:
            if char not in current_node.children:
                current_node.children[char]=TrieNode(char)
            current_node = current_node.children[char]
            current_node.prefix_count += 1
        current_node.end_of_word = True
        current_node.word_count += 1
    
    def find_prefix(self, prefix):
        current_node = self.root

        for char in prefix:
            if char not in current_node.children:
                return False
            current_node = current_node.children[char]
        return True
    
    def search_word(self, word):
        current_node = self.root

        for char in word:
            if char not in current_node.children:
                return False
            current_node = current_node.children[char]
        return current_node.end_of_word
    
    def delete_word(self, word):
        def delete(current_node, word, depth ):
            if len(word) == depth:
                if not current_node.end_of_word:
                    return False
                current_node.end_of_word = False
                current_node.word_count -= 1
                return len(current_node.children) == 0
            
            char = word[depth]
            if char not in current_node.children:
                return False
            
            should_delete = delete(current_node.children[char], word, depth+1)

            if should_delete:
                del current_node.children[char]

            current_node.prefix_count -= 1
            return len(current_node.children) == 0 and not current_node.end_of_word
            
        
        delete(self.root, word, 0)
    
    def count_no_of_words(self, word):
        current_node = self.root
        for char in word: 
            if char not in current_node.children:
                return 0
            current_node = current_node.children[char]
        print("words_count:" ,current_node.word_count)
    
    def count_no_of_prefix(self, word):
        current_node = self.root
        for char in word:
            if char not in current_node.children:
                return 0
            current_node = current_node.children[char]
        print("prefix_count:", current_node.prefix_count)
    
    def traverse_in_trie(self, current_node=None, prefix=""):
        if current_node == None:
            current_node = self.root
        
        if current_node.end_of_word:
            print(prefix)

        for char, child in current_node.children.items():
            self.traverse_in_trie( child, prefix+char)
    
    def longest_common_prefix(self, current_node=None, prefix = ""):
        if current_node == None:
            current_node = self.root
        
        if len(current_node.children) == 1 and not current_node.end_of_word:
            for char, child in current_node.children.items():
                self.longest_prefix(child, prefix+char)
        else:
            print("longest prefix: ", prefix)    


    
trie = Trie()


trie.insert("cat")
trie.insert("car")
trie.insert("care")

trie.traverse_in_trie()

trie.count_no_of_words("car")
trie.count_no_of_prefix("ca")

trie.delete_word("car")
trie.traverse_in_trie()
trie.longest_prefix()
