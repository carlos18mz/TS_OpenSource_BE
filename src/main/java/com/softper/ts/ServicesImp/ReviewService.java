package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Cargo;
import com.softper.ts.Model.Qualification;
import com.softper.ts.Model.Review;
import com.softper.ts.Repositories.ICargoRepository;
import com.softper.ts.Repositories.IQualificationRepository;
import com.softper.ts.Repositories.IReviewRepository;
import com.softper.ts.Resources.Comunications.PriceResponse;
import com.softper.ts.Resources.Comunications.ReviewResponse;
import com.softper.ts.Resources.Outputs.ReviewOutput;
import com.softper.ts.Resources.Inputs.ReviewInput;
import com.softper.ts.Services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    @Override
    public ReviewResponse findAllReviews() {
        return null;
    }

    @Override
    public ReviewResponse findReviewsByCustomerId(int customerId) {
        return null;
    }

    @Override
    public ReviewResponse findReviewsByDriverId(int driverId) {
        return null;
    }

    @Override
    public ReviewResponse findReviewById(int reviewId) {
        return null;
    }

    @Override
    public ReviewResponse addReviewByCargoId(int cargoId, ReviewInput reviewInput) {
        return null;
    }

    @Override
    public Review save(Review review) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Review> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Review> findAll() throws Exception {
        return null;
    }
}
