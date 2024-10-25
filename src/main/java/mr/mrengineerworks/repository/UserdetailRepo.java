package mr.mrengineerworks.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mr.mrengineerworks.entity.UserDetails;

@Repository
public interface UserdetailRepo  extends MongoRepository<UserDetails,ObjectId>{
    
    
}
