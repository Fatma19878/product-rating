package ProductRating;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

public class RatingProducer {
    public static void main(String[] args) {
        // إعداد الخصائص
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (
            KafkaProducer<String, String> producer = new KafkaProducer<>(props);
            Scanner scanner = new Scanner(System.in)
        ) {
            int ratingCount = 1;

            while (true) {
                System.out.println("=== Rating #" + ratingCount + " ===");
                System.out.print("Enter User ID (or type 'exit' to quit): ");
                String userId = scanner.nextLine();
                if ("exit".equalsIgnoreCase(userId)) break;

                System.out.print("Enter Product ID: ");
                String productId = scanner.nextLine();

                System.out.print("Enter Rating (1 to 5): ");
                String rating = scanner.nextLine();

                String message = "UserID: " + userId + ", ProductID: " + productId + ", Rating: " + rating;

                producer.send(new ProducerRecord<>("product-ratings", userId, message));

                System.out.println("\n✔️ Rating sent to Kafka:");
                System.out.println("User ID   : " + userId);
                System.out.println("Product ID: " + productId);
                System.out.println("Rating    : " + rating);
                System.out.println("=============================\n");

                ratingCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
