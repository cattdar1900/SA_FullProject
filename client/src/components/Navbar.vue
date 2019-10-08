<template>
    <nav>
        <v-app-bar app dark>
            <v-toolbar-title class="headline text-uppercase">
                <span>DOCTOR'S ORDER</span>
                <span class="font-weight-light"></span>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn 
                text
                href="viewedOrder"
                target="_blank"
            >
                <v-icon left>like</v-icon>
                <span class="mr-2">ประวัติการสั่งจ่ายยา</span>
            </v-btn>
            
            <v-btn 
                text
                href="signout"
                
            >
                <v-icon left>like</v-icon>
                <span class="mr-2">Exit</span>
            </v-btn>
        </v-app-bar>
    </nav>
</template>

<script>
export default {

}
</script>