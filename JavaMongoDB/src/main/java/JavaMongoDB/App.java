package JavaMongoDB;

import org.bson.Document;

//import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;

public class App {

	public static void main(String[] args) {
		var connection = new Connection().getConnection();
		
		//CREATE COLLECTION
		//connection.createCollection("people");
		
		MongoCollection<Document> peopleCollection = connection.getCollection("people");
		
		//CREATE DOCUMENT
		//createNewDoc(peopleCollection, "teste1", 19);
		//createNewDoc(peopleCollection, "teste2", 91);
		
		//READ
		//	FINDALL
		for(Document doc : findAll(peopleCollection)) {
			System.out.println(doc);
		}
		//	FINDBY
		System.out.println(findBy(peopleCollection, "name", "willian").first());
		System.out.println(findBy(peopleCollection, "age", 31).first());

		//UPDATE
		peopleCollection.findOneAndUpdate(eq("name","teste1"), new Document("$set", new Document("age", 55)) );
		
		//DELETE: find and delete
		//peopleCollection.deleteOne(eq("name", "teste1"));
		//peopleCollection.deleteOne(eq("name", "teste2"));
		
//		Block<Document> block = new Block<Document>() {
//			@Override
//			public void apply(Document t) {
//				var age = t.getInteger("age");
//			
//				if(age == 31) {
//					System.out.println("Willian é você?");
//				}
//			
//				System.out.println(t.toJson());
//			}
//		};
	}
	
	public static FindIterable<Document> findBy(MongoCollection<Document> collection, String fieldName, Object value){
		return collection.find(eq(fieldName, value));
	}
	
	public static FindIterable<Document> findAll(MongoCollection<Document> collection){
		return collection.find();
	}
	
	public static void createNewDoc(MongoCollection<Document> collection, String name, Integer age) {
		Person p = new Person(name, age);
		Document document = new Document();
		
		document.append("name",p.getName());
		document.append("age",p.getAge());
		
		collection.insertOne(document);
	}

}
