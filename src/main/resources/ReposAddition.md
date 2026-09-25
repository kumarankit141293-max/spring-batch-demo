
## 🔹 Step‑by‑Step Process with Commands

1. **Project folder में जाएँ**
   ```bash
   cd C:\Users\ak14d\Desktop\SpringBatch
   ```

2. **Git initialize करें**
   ```bash
   git init
   ```

3. **GitHub पर repository create करें**
    - GitHub → New Repository → Name: `spring-batch-demo` → Create.

4. **Remote origin add करें**
   ```bash
   git remote add origin https://github.com/kumarankit141293-max/spring-batch-demo.git
   ```

5. **Git config setup करें (पहली बार)**
   ```bash
   git config --global user.name "Ankit Kumar"
   git config --global user.email "kumaranakit141293@gmail.com"
   ```

6. **Files stage करें**
   ```bash
   git add .
   ```

7. **पहला commit करें**
   ```bash
   git commit -m "Initial commit"
   ```

8. **Branch को main में rename करें**
   ```bash
   git branch -M main
   ```

9. **Remote verify करें**
   ```bash
   git remote -v
   ```

10. **Push करें GitHub पर**
    ```bash
    git push -u origin main
    ```

---

## ✅ Summary
- पहले GitHub पर repository बनानी ज़रूरी है।
- फिर local repo initialize → remote add → config set → commit → branch rename → push।
- इसके बाद आपका project GitHub repository में दिखाई देगा।
