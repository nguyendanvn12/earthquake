package com.nguyendan.earthquake.data.remote;

import com.nguyendan.earthquake.data.model.QuakeReport;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuakeReportService {
    @GET("query?format=geojson&starttime=2015-01-01&endtime=2016-01-31&minmag=1&limit=100")
    Call<QuakeReport> getFeature();

}
