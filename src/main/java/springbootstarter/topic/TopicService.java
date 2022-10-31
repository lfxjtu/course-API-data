package springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private final List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framework", "Spring Framework Description"),
//            new Topic("java", "Java Core", "Java Core Description"),
//            new Topic("javascript", "Javascript name", "Javascript Description")
//    ));

    public List<Topic> getAllTopics() {
//        return topics1;
        List<Topic> topics1 = new ArrayList<>();
        topicRepository.findAll().forEach(topics1::add);
        return topics1;
    }

    public Topic getTopic(String id) {
//        Optional<Topic> topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst();
//        return topic.orElse(null);
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.orElse(null);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        for (int i = 0; i < topics.size(); i++) {
//            if (topics.get(i).getId().equals(id)) {
//                topics.set(i, topic);
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(topic -> topic.getId().equals(id));
        topicRepository.deleteById(id);
    }
}

