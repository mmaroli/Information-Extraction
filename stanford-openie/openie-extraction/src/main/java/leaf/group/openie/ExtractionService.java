package leaf.group.openie;

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.util.Collection;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class ExtractionService implements IExtractionService {

  private StanfordCoreNLP pipeline;

  public ExtractionService() {
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
    this.pipeline = new StanfordCoreNLP(props);
  }

  @Override
  public List<Collection<String>> extract( String sent) {

    System.out.println(sent);
    Annotation doc = new Annotation(sent);

    this.pipeline.annotate(doc);

    List<Collection<String>> tripleList = new ArrayList<Collection<String>>();


    for (CoreMap sentence: doc.get(CoreAnnotations.SentencesAnnotation.class)) {
      Collection<RelationTriple> triples = sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);

      Collection<String> tmp_triples = new ArrayList<String>();
      for (RelationTriple triple: triples) {
        System.out.println(triple.confidence + "\t" +
          triple.subjectLemmaGloss() + "\t" +
          triple.relationLemmaGloss() + "\t" +
          triple.objectLemmaGloss());

        tmp_triples.add(triple.toString());
      }
      tripleList.add(tmp_triples);
    }
    System.out.println(tripleList);
    return tripleList;
  }
}
