package com.talentscity.com.Services;

import com.talentscity.com.Entities.Dislike;
import com.talentscity.com.Entities.Like;
import com.talentscity.com.Entities.User;
import com.talentscity.com.Entities.Video;

public interface UnlikeVideoService {
//    void deleteLikeByLikeID(Long likeID);
    Dislike unlikeVideo(Dislike dislike);
    Dislike getUserUnlikeEntry(User user, Video video);
    void deleteVideoUnlikeRecord(Dislike dislike);

}
