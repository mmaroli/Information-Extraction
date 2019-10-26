package leaf.group.openie;

import java.util.List;
import java.util.Collection;
import edu.stanford.nlp.ie.util.RelationTriple;

public class Openie {

  private String sentence;
  private List<Collection<String>> triples;

  public Openie() {}

  public Openie(String sentence) {
    this.sentence = sentence;
  }

  public Openie(String sentence, List<Collection<String>> triples) {
    this.sentence = sentence;
    this.triples = triples;
  }

  public String getSentence() {
    return sentence;
  }

  public List<Collection<String>> getTriples() {
    return triples;
  }

}
