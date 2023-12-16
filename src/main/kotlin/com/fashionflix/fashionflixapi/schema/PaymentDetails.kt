package com.fashionflix.fashionflixapi.schema

class PaymentDetails(
    val paymentId: String,
    val paymentMethod: String,
    val paymentStatus: String,
    val razorpayPaymentLinkId: String,
    val razorpayPaymentLinkReferenceId: String,
    val razorpayPaymentLinkStatus: String,
    val razorpayPaymentId: String
){


}