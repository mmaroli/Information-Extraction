package leaf.group.openie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Collection;
import edu.stanford.nlp.ie.util.RelationTriple;


@RestController
public class OpenieController {

  @Autowired
  private ExtractionService extractionService;

  @RequestMapping(value="/openie", method=RequestMethod.POST)
  public Openie openie(@RequestBody Openie sent) {
    List<Collection<String>> response = extractionService.extract(sent.getSentence());
    return new Openie(sent.getSentence(), response);
  }
}
