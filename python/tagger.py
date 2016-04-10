import sys
import nltk

# plik z tekstem
dataPath = sys.argv[1]
fileName = sys.argv[2]
dataFile = open(dataPath + fileName)
text = dataFile.read()
dataFile.close()
tokens = nltk.word_tokenize(text)
tagged = nltk.pos_tag(tokens)
# plik z oznaczonym tekstem
tagFile = open(dataPath + "tag_" + fileName , 'w')
tagFile.write('\n'.join('%s %s' % x for x in tagged))
tagFile.close()
