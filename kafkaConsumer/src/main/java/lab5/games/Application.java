package lab5.games;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab5.games.db.dao.GameRepository;
import lab5.games.db.model.GamesEntity;
import lab5.games.service.GameService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import scala.Int;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

@ComponentScan
@EnableAutoConfiguration
public class Application {
        DataBaseExecutor dbe;
        String topicName = "testTopic";
        Properties props = null;
        public void myrun() {
            __init__();
            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topicName));
            System.out.println("Subscribed to topic " + topicName);

            //loopforever))
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1);
                for (ConsumerRecord<String, String> record : records) {
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        GamesEntity tmp = mapper.readValue(record.value(), GamesEntity.class);
                        switch (record.key()) {
                            //delete
                            case "0":
                                dbe.delete_game(tmp.getId().toString());
                                System.out.println("Delete");
                                break;
                            //append
                            case "1":
                                dbe.append(tmp.getName(), tmp.getStudioName(), tmp.getCost().toString(), tmp.getPhoto(), tmp.getDescription());
                                System.out.println("Append");
                                break;
                            //update
                            case "2":
                                dbe.change(tmp.getId().toString(), tmp.getName(), tmp.getStudioName(), tmp.getCost().toString(), tmp.getPhoto(), tmp.getDescription());
                                System.out.println("Update");
                                break;
                            default:
                                System.out.println("You break the my rule");
                        }
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void __init__(){
            dbe = new DataBaseExecutor();
            props = new Properties();
            props.put("bootstrap.servers", "localhost:9092");
            props.put("group.id", "test");
            props.put("enable.auto.commit", "true");
            props.put("auto.commit.interval.ms", "1000");
            props.put("session.timeout.ms", "30000");
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer",  "org.apache.kafka.common.serialization.StringDeserializer");
        }

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplicationBuilder(Application.class).build();
        app.run(args);
        new Application().myrun();
    }

}
