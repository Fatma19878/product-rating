package ProductRating;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class RatingConsumer {
    public static void main(String[] args) {
        // إعداد الخصائص
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "rating-consumer-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList("product-ratings"));
            System.out.println("🎧 Listening for product ratings...");

            int messageCount = 1;

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));

                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("=== Received Rating #" + messageCount + " ===");

                    // الرسالة بصيغة: UserID: u123, ProductID: p456, Rating: 4
                    String[] parts = record.value().split(", ");
                    for (String part : parts) {
                        System.out.println("➡️ " + part);
                    }

                    System.out.println("==============================\n");
                    messageCount++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
