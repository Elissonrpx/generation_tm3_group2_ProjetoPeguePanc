package com.generation.projetopanc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.generation.projetopanc.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity(){

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener{
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if(pass == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener{
                            if(it.isSuccessful){
                                val intent = Intent(this, SignInActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                }else{
                    Toast.makeText(this,"Senhas não são iguais!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Não são permitidos campos vazios!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}