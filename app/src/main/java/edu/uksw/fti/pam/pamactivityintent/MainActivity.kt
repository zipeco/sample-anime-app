package edu.uksw.fti.pam.pamactivityintent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uksw.fti.pam.acitivityintent.contracts.SignUpContract
import edu.uksw.fti.pam.pamactivityintent.ui.screens.DefaultPreview
import edu.uksw.fti.pam.pamactivityintent.ui.screens.LoginForm
import edu.uksw.fti.pam.pamactivityintent.ui.screens.MainScreenView
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMActivityIntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    LoginForm()
                    DefaultPreview()
                }
            }
        }
    }

}