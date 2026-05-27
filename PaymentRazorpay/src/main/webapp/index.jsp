<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-4.0.0.min.js" integrity="sha256-OaVG6prZf4v69dPg6PhVattBXkcOWQB62pdZ3ORyrao=" crossorigin="anonymous"></script>
</head>
<body>

	<!-- <button id="rzp-button1">Pay with Razorpay</button>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script>
		var options = {
			"key" : "rzp_test_Sa8aFOhsEWOycn", // Enter the Key ID generated from the Dashboard
			"amount" : "50000", // Amount is in currency subunits. 
			"currency" : "INR",
			"name" : "Acme Corp",
			"description" : "Test Transaction",
			"image" : "https://example.com/your_logo",
			"order_id" : "order_Sa9PbM3n72tEXt", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
			"handler" : function(response) {
				alert(response.razorpay_payment_id);
				alert(response.razorpay_order_id);
				alert(response.razorpay_signature)
			},
			"prefill" : {
				"name" : "Darshan",
				"email" : "drsn@gmail.com",
				"contact" : "8320858835"
			},
			"notes" : {
				"address" : "Razorpay Corporate Office"
			},
			"theme" : {
				"color" : "#3399cc"
			}
		};
		var rzp1 = new Razorpay(options);
		rzp1.on('payment.failed', function(response) {
			alert(response.error.code);
			alert(response.error.description);
			alert(response.error.source);
			alert(response.error.step);
			alert(response.error.reason);
			alert(response.error.metadata.order_id);
			alert(response.error.metadata.payment_id);
		});
		document.getElementById('rzp-button1').onclick = function(e) {
			
			/* here we want to call get method(/payment). rzp1 open ho usse pehle hame get method ko call karna hai*/
			/* So, we have to work with Ajax. How we can call that ? ------ */
			
			//$.get("payment",{},function(rt){     /* here rt - response text */
			//	alert(rt)    /* rt tab milega jab ham controller se rt ko bhejenge */
			//})
			
			//$.get("payment",{},function(rt){    
			//	alert(rt.id)   //hame output me undefined milega. Why? bcoz rt json format me hai. So, rt ko hame vapas object me lana padega.So,.... 
			//})
			
			$.get("payment",{},function(rt){    
				const data = JSON.parse(rt)
				//alert(data)   //output - "[object Object]" Hame object milega. Par hame object nahi id chahiye. So,-- alert(data.id)
				alert(data.id)   //now we got orderid. output- "order_SaB7TBkFN9onjQ"
			})
			
			//rzp1.open();
			//e.preventDefault();
		}
	</script> -->
	
	<!-- ham amount bhi fix nahi rakh sakte. Wo bhi change hoti rahegi. So, -- -->
	<input type="text" placeholder="Enter amount" id="amt">
	<!-- ye amount ka payment karvana hai. So,.. var amt = $("#amt") -->
	<button id="rzp-button1">Pay with Razorpay</button>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script>
		
		document.getElementById('rzp-button1').onclick = function(e) {
			
			e.preventDefault();

			var amt = $("#amt").val()
			$.get("payment",{amt},function(rt){    //jese hi ye payment request call hogi, waha pe hame amt get karna padega. 
				const data = JSON.parse(rt)
				//alert(data.id)  
				
		
		var options = {
					"key" : "rzp_test_Sa8aFOhsEWOycn", //Enter the Key ID generated from the Dashboard
					"amount" : data.amount, // Amount is in currency subunits. 
					"currency" : "INR",
					"name" : "Acme Corp",
					"description" : "Test Transaction",
					"image" : "https://example.com/your_logo",
					"order_id" : data.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
					"handler" : function(response) {
						alert(response.razorpay_payment_id);
						alert(response.razorpay_order_id);
						alert(response.razorpay_signature)
					},
					"prefill" : {
						"name" : "Darshan",
						"email" : "drsn@gmail.com",
						"contact" : "8320858835"
					},
					"notes" : {
						"address" : "Razorpay Corporate Office"
					},
					"theme" : {
						"color" : "#3399cc"
					}
				};
				var rzp1 = new Razorpay(options);
				rzp1.on('payment.failed', function(response) {
					alert(response.error.code);
					alert(response.error.description);
					alert(response.error.source);
					alert(response.error.step);
					alert(response.error.reason);
					alert(response.error.metadata.order_id);
					alert(response.error.metadata.payment_id);
				});

				rzp1.open();
			})
		}
	</script>

</body>
</html>