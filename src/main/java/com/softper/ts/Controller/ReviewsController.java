package com.softper.ts.Controller;


import com.softper.ts.Model.Review;
import com.softper.ts.Resources.Comunications.ReviewResponse;
import com.softper.ts.Resources.Inputs.ReviewInput;
import com.softper.ts.Services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    private IReviewService reviewService;

    @GetMapping
    public ResponseEntity<ReviewResponse> findAllReviews()
    {
        ReviewResponse result = reviewService.findAllReviews();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<ReviewResponse> findReviewsByCustomerId(@PathVariable(value = "customerId")int customerId)
    {
        ReviewResponse result = reviewService.findReviewsByCustomerId(customerId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/drivers/{driverId}")
    public ResponseEntity<ReviewResponse> findReviewsByDriverId(@PathVariable(value = "driverId")int driverId)
    {
        ReviewResponse result = reviewService.findReviewsByDriverId(driverId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> findReviewById(@PathVariable(value = "reviewId")int reviewId)
    {
        ReviewResponse result = reviewService.findReviewById(reviewId);
        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/cargoes/{cargoId}")
    public ResponseEntity<ReviewResponse> addReviewByCargoId(@PathVariable(value = "cargoId")int cargoId, @Valid @RequestBody ReviewInput reviewInput)
    {
        ReviewResponse result = reviewService.addReviewByCargoId(cargoId, reviewInput);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
