package com.esprit.entities ;

import java.util.Date;

public class Review {
	
	private int id ;
	private String review ;
	private String reviewDate ;
	private int rate ;
        private User user;
	
	public Review(int id, String review, String reviewDate, int rate) {
		this.id = id;
		this.review = review;
		this.reviewDate = reviewDate;
		this.rate = rate;
	}
	
	public Review() {
	}
        
        public Review(String review,int rate) {
            this.review =review;
            this.rate =rate;
	}
        
               public Review(int id,String review,int rate) {
                   this.id = id;
            this.review =review;
            this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + rate;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Review))
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		if (rate != other.rate)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (reviewDate == null) {
			if (other.reviewDate != null)
				return false;
		} else if (!reviewDate.equals(other.reviewDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + review + ", reviewDate=" + reviewDate + ", rate=" + rate + "]";
	}
}
