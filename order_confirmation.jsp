<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order Confirmation</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Arial', sans-serif;
      background: linear-gradient(135deg, #ff7f50, #ff6b6b);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      overflow: hidden;
    }

    .confirmation-container {
      text-align: center;
      background: white;
      padding: 40px 60px;
      border-radius: 20px;
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
      animation: fadeIn 1.5s ease-in-out, float 4s ease-in-out infinite;
      position: relative;
    }

    h1 {
      font-size: 2.5rem;
      color: #333;
      margin-bottom: 20px;
      animation: slideIn 1s ease-in-out;
    }

    p {
      font-size: 1.2rem;
      color: #666;
      animation: slideIn 1.2s ease-in-out;
    }

    .checkmark {
      width: 80px;
      height: 80px;
      border-radius: 50%;
      background: #4caf50;
      margin: 0 auto 20px;
      position: relative;
      animation: scaleIn 0.8s ease-in-out, glow 2s infinite alternate;
    }

    .checkmark::after {
      content: '';
      position: absolute;
      left: 25px;
      top: 40px;
      width: 25px;
      height: 50px;
      border: solid white;
      border-width: 0 4px 4px 0;
      transform: rotate(45deg);
      animation: checkmarkDraw 0.8s ease-in-out;
    }

    /* Background Animation */
    body::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: radial-gradient(circle, rgba(255, 255, 255, 0.1) 10%, transparent 10.01%);
      background-size: 20px 20px;
      animation: moveBackground 10s linear infinite;
      z-index: -1;
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translateY(-20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    @keyframes slideIn {
      from {
        opacity: 0;
        transform: translateX(-50px);
      }
      to {
        opacity: 1;
        transform: translateX(0);
      }
    }

    @keyframes scaleIn {
      from {
        transform: scale(0);
      }
      to {
        transform: scale(1);
      }
    }

    @keyframes checkmarkDraw {
      0% {
        height: 0;
        width: 0;
        opacity: 0;
      }
      50% {
        height: 0;
        width: 25px;
        opacity: 1;
      }
      100% {
        height: 50px;
        width: 25px;
        opacity: 1;
      }
    }

    @keyframes float {
      0%, 100% {
        transform: translateY(0);
      }
      50% {
        transform: translateY(-10px);
      }
    }

    @keyframes glow {
      0% {
        box-shadow: 0 0 10px #4caf50, 0 0 20px #4caf50;
      }
      100% {
        box-shadow: 0 0 20px #4caf50, 0 0 40px #4caf50;
      }
    }

    @keyframes moveBackground {
      from {
        transform: translateY(0);
      }
      to {
        transform: translateY(20px);
      }
    }
  </style>
</head>
<body>
  <div class="confirmation-container">
    <div class="checkmark"></div>
    <h1>Order Confirmed!</h1>
    <p>Thank you for your order. Your food is being prepared.</p>
  </div>
</body>
</html>