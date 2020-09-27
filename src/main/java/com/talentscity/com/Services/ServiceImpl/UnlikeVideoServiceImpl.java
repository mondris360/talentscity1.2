package com.talentscity.com.Services.ServiceImpl;

import com.talentscity.com.Entities.Dislike;
import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;
import com.talentscity.com.Repositories.LikeVideoRepository;
import com.talentscity.com.Repositories.UnlikeVideoRepository;
import com.talentscity.com.Services.UnlikeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;

@Transactional
@Controller
public class UnlikeVideoServiceImpl implements UnlikeVideoService {
    private UnlikeVideoRepository unlikeVideoRepository;
    private LikeVideoRepository likeVideoRepository;

    @Autowired
    public UnlikeVideoServiceImpl(UnlikeVideoRepository unlikeVideoRepository, LikeVideoRepository likeVideoRepository) {
        this.unlikeVideoRepository = unlikeVideoRepository;
        this.likeVideoRepository = likeVideoRepository;
    }


    // method to delete a user  video like
    public void c(Like like) {
        likeVideoRepository.delete(like);
    }

    @Override
    // method to unlike a video
    public Dislike unlikeVideo(Dislike unlike) {

        return unlikeVideoRepository.save(unlike);
    }

    @Override
    // method to get the unlike entry of a  user for a particular video
    public Dislike getUserUnlikeEntry(User user, Video video) {
        return unlikeVideoRepository.findDislikeByUserAndVideo(user, video);
    }

    @Override
    // delete  the unlike user entry for the video
    public void deleteVideoUnlikeRecord(Dislike dislike) {
        System.out.println("dislike inside deleteVideoUnlikeRecord" + dislike);
        unlikeVideoRepository.deleteById(dislike.getId());
    }


}
