import { createClient } from '@supabase/supabase-js'

const supabaseUrl = "https://qgqtadhpqirxnscpfgle.supabase.co"
const supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InFncXRhZGhwcWlyeG5zY3BmZ2xlIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTUxNTYzNzAsImV4cCI6MjA3MDczMjM3MH0.0505ORLaNp7LPT7vRT1_9zH4jS_NnvQqj4lr03lE5Ew"

export const supabase = createClient(supabaseUrl, supabaseKey)