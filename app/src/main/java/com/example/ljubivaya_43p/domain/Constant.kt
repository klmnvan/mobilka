package com.example.ljubivaya_43p.domain

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.SessionSource
import io.github.jan.supabase.postgrest.Postgrest


object Constant {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://iouqlycwbfmornzbwcuj.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImlvdXFseWN3YmZtb3JuemJ3Y3VqIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjU2MTM3MDIsImV4cCI6MjA0MTE4OTcwMn0.e_sqivSkf9Mk8011-Cw9q2c2u7Z8TyKPIxa9Bz-rrhw"
    ) {
        install(Postgrest)
        install(Auth)
    }
}