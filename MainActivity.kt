package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 1) Références vers les champs de saisie
    private lateinit var nom: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var adresse: EditText
    private lateinit var ville: EditText
    private lateinit var btnEnvoyer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des vues
        nom = findViewById(R.id.nom)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        adresse = findViewById(R.id.adresse)
        ville = findViewById(R.id.ville)
        btnEnvoyer = findViewById(R.id.btnEnvoyer)

        btnEnvoyer.setOnClickListener {
            val sNom = nom.text.toString().trim()
            val sEmail = email.text.toString().trim()
            val sPhone = phone.text.toString().trim()
            val sAdresse = adresse.text.toString().trim()
            val sVille = ville.text.toString().trim()

            // Validation : On vérifie que les champs cruciaux ne sont pas vides
            if (sNom.isEmpty() || sEmail.isEmpty()) {
                // Utilisation de this@MainActivity pour être sûr du contexte dans un listener
                Toast.makeText(this@MainActivity, "Nom et Email sont obligatoires.", Toast.LENGTH_SHORT).show()
            } else {
                // Création de l'Intent
                // ATTENTION : Vérifie bien que le fichier Screen2Activity.kt existe !
                val i = Intent(this@MainActivity, Screen2Activity::class.java)

                i.putExtra("nom", sNom)
                i.putExtra("email", sEmail)
                i.putExtra("phone", sPhone)
                i.putExtra("adresse", sAdresse)
                i.putExtra("ville", sVille)

                startActivity(i)
            }
        }
    }
}

