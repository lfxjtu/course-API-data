package springbootstarter.course;

import lombok.Getter;
import lombok.Setter;
import springbootstarter.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter

@Entity
public class Course {

    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "topicId")
    private Topic topic;

    public Course() {
    }

    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "","");
    }

}
