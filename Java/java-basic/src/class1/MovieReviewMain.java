package class1;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview movieReview1 = new MovieReview();
        movieReview1.title = "인셉션";
        movieReview1.review = "인생은 무한 루프";

        MovieReview movieReview2 = new MovieReview();
        movieReview2.title = "어바웃 타임";
        movieReview2.review = "인생 시간 영화";

        MovieReview[] movieReviews = new MovieReview[]{movieReview1, movieReview2};
        for(MovieReview m : movieReviews){
            System.out.printf("영화제목 : \" %s \", 리뷰 : \" %s \" %n", m.title, m.review);
        }
    }
}
