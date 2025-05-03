   ![Java](https://img.shields.io/badge/Java-17-blue)
   ![Kafka Streams](https://img.shields.io/badge/Kafka_Streams-3.7.0-orange)
   ![Maven](https://img.shields.io/badge/Maven-3.9.6-green)

   A real-time product rating processing application built with Apache Kafka Streams. This project processes user ratings for products, calculates average ratings per product, and outputs results to a Kafka topic.

   ## Features
   - Real-time processing of product ratings using Kafka Streams.
   - Aggregation of ratings by product ID to compute average ratings.
   - Simple Producer to simulate user ratings.

   ## Technologies Used
   - **Java**: 17
   - **Apache Kafka Streams**: 3.7.0
   - **Maven**: Build tool
   - **Apache Kafka**: Messaging system

   ## Getting Started

   ### Prerequisites
   - Java 17 (e.g., Eclipse Adoptium JDK)
   - Maven 3.9.6
   - Apache Kafka 3.7.0 (with ZooKeeper)

   ### Installation
   1. Clone the repository:
      ```bash
      git clone https://github.com/Fatma19878/product-rating.git
      cd product-rating
      ```
   2. Build the project:
      ```bash
      mvn clean install
      ```

   ## Contributing
   Contributions are welcome! Please open an issue or submit a pull request.

   ## License
   This project is licensed under the MIT License.