package mr.mrengineerworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mr.mrengineerworks.entity.UserDetails;
import mr.mrengineerworks.repository.UserdetailRepo;

@Service
public class UserDetailService {

    

    @Autowired
    private UserdetailRepo userDetailRepo;


    public UserDetails saveUser(UserDetails userDetails){
          return userDetailRepo.save(userDetails); 
        }
     
        
    
}
