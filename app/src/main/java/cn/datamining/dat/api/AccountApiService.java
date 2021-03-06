package cn.datamining.dat.api;

import cn.datamining.dat.db.User;
import cn.datamining.dat.components.retrofit.BaseResponse;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wushange on 2017/7/11.
 */

public interface AccountApiService {
    @FormUrlEncoded
    @POST("login")
    Observable<BaseResponse<User>> login(@Field("userPhone") String name, @Field("password") String password);
}
