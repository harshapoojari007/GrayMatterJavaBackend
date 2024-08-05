<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/70562393cb.js" crossorigin="anonymous"></script>
    <title>About</title>

</head>

<body onload="showAlert('<%= request.getAttribute("alertMessage") != null ? request.getAttribute("alertMessage") : "" %>')">
    <header>
 
        <div>
            <h1 style="display: block;">FoodFoodie</h1>
        </div>
        <nav>
            <div class="ul">
                <ul type="none">
                    <a href="index.jsp"><li>HOME</li></a>
                    <a href="about.jsp"><li>ABOUT US</li></a>
            </div>

        </nav>
    </header>
    <div style="margin-left:20%;margin-right:20%;color:black;"> 
          <h1>Developer Harsha Poojari</h1>
          <h5>This is Food Ordering Website</h5>
          <p>Our MissionAt FoodFoodie, our mission is to provide delicious, fresh, and convenient meals that bring people together. </p>
         <p> We strive to offer a wide variety of food options to cater to different tastes and dietary needs, all while ensuring top-notch quality and service.</p>

      <h6>Our Story</h6> 
     <p>Founded in 2024, FoodFoodie started as a small local restaurant with a big dream: to revolutionize the way people experience food. Over the years, we've grown into a leading online food ordering platform, partnering with top restaurants and chefs to bring you the best culinary delights right to your doorstep.
     </p>


<h6>What Sets Us Apart</h6> 

<div>Quality Ingredients: We prioritize high-quality, fresh ingredients in every dish to ensure great taste and nutrition.
Diverse Menu: Our extensive menu features a wide range of cuisines and dishes, from comfort foods to gourmet meals.
Convenience: Order from the comfort of your home or on-the-go with our easy-to-use platform and fast delivery service.
Customer Satisfaction: Our dedicated customer service team is here to assist you and ensure your dining experience is exceptional.
Our Values
</div>
<p>We believe in quality, integrity, and customer satisfaction. </p>
<p>Our team is committed to providing an exceptional food ordering experience and maintaining the highest standards in everything we do.</p>
        
 </div>
    <footer>
        <p>We use cookies to provide a user-friendly experience. By continuing to browse this site, you agree to the use
            of cookies. To view our cookie policy, click here</p>

        <p>© Copyright FoodFoodie Ltd. Terms and Conditions Privacy Policy</p>
    </footer>
</body>

</html>>