from flask import Flask, request, jsonify
import joblib
import pandas as pd

# Flask uygulamasını başlat
app = Flask(__name__)

# 📌 .pkl dosyasını yükle (aynı klasörde olmalı)
model = joblib.load("random_forest_model.pkl")

# Tahmin endpoint'i
@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Kullanıcıdan gelen JSON verisini al
        data = request.get_json()

        # Tek satırlık veriyi DataFrame'e çevir
        df = pd.DataFrame([data])

        # Tahmin yap
        prediction = model.predict(df)

        # Tahmini JSON formatında döndür
        return jsonify({'prediction': float(prediction[0])})

    except Exception as e:
        return jsonify({'error': str(e)})

# Uygulamayı çalıştır
if __name__ == '__main__':
    app.run(debug=True)
