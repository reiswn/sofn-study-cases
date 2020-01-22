package JavaMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connection {

	public MongoDatabase getConnection() {
		var mongoClient = new MongoClient();
		MongoDatabase mongoDB = mongoClient.getDatabase("java_mongo");
		//mongoClient.close();
		return mongoDB;
	}
	
//	public void exemplos(String[] args) {
//		@SuppressWarnings("resource")
//		var mongoClient = new MongoClient("localhost", 27017);
//		
//		//Create new db if not exist
//		var database = mongoClient.getDatabase("java_mongo");
//		
//		//Get a collection
//		MongoCollection<Document> collection = database.getCollection("people");
//
//		//Create a new collection - do it just ONE time
//		database.createCollection("people");
//		
//		for(String name : database.listCollectionNames()) {
//			System.out.println(name);
//		}
//		
//		collection.drop();
//		
//		for(String name : database.listCollectionNames()) {
//			System.out.println(name);
//		}
//	}	
}