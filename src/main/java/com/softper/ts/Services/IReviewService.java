package com.softper.ts.Services;

import com.softper.ts.Model.Review;
import com.softper.ts.Resources.Comunications.ReviewResponse;
import com.softper.ts.Resources.Outputs.ReviewOutput;
import com.softper.ts.Resources.Inputs.ReviewInput;

import java.util.List;

public interface IReviewService extends ICrudService<Review> {
    ReviewResponse findAllReviews();
    ReviewResponse findReviewsByCustomerId(int customerId);
    ReviewResponse findReviewsByDriverId(int driverId);
    ReviewResponse findReviewById(int reviewId);
    ReviewResponse addReviewByCargoId(int cargoId, ReviewInput reviewInput);
}
