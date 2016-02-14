import sys
import nltk

# plik z tekstem
fileName = sys.argv[1]
dataFile = open("C:/data/" + fileName)
text = dataFile.read()
dataFile.close()
tokens = nltk.word_tokenize(text)
tagged = nltk.pos_tag(tokens)
# plik z oznaczonym tekstem
tagFile = open("C:/data/tag_" + fileName , 'w')
tagFile.write('\n'.join('%s %s' % x for x in tagged))
tagFile.close()
