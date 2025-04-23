# Number Grid Highlighter - Android App (Kotlin)

An Android app built in **Kotlin** that displays numbers from **1 to 100** in a grid and highlights them based on selected rules like odd, even, prime, or Fibonacci numbers.

## 📱 Features

- Grid layout showing numbers 1 to 100
- Highlight numbers based on selected pattern:
  - 🔹 Odd Numbers
  - 🔹 Even Numbers
  - 🔹 Prime Numbers
  - 🔹 Fibonacci Numbers
- Dynamic selection using a `Spinner`
- Optimized logic for prime and Fibonacci rules
- Smooth UI updates when switching between rules

## 🧑‍💻 Built With

- **Kotlin**
- **Android SDK**
- **GridView**
- **Spinner**
- **Custom Adapter**
- **Efficient Algorithms**
  - Prime check using `√n` logic
  - Fibonacci generation using iteration
- **MVVM Ready Structure** *(logic separation is clean and scalable)*

## 🧠 How It Works

1. App displays a grid of numbers from 1 to 100 using `GridView`.
2. User selects a rule from the `Spinner` dropdown.
3. Matching numbers are calculated using helper functions.
4. Highlighted numbers are shown in a different color/style.
5. Grid updates in real-time as per selected rule.

## 🔁 Rules Handled with Kotlin Logic

- `isOdd(number: Int): Boolean`
- `isEven(number: Int): Boolean`
- `isPrime(number: Int): Boolean`
- `getFibonacciNumbersUpTo(limit: Int): Set<Int>`


## ⚙️ How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/your-username/number-grid-highlighter.git
