<template>
  <div id="container">
    <headbar id="headbar" class="home-element" />
    <sidebar id="sidebar" class="home-element" />
    <item-list id="item-list" class="home-element" />
    <ordering-screen id="ordering-screen" class="home-element" />
  </div>
</template>

<script>
// @ is an alias to /src
import Headbar from '../components/Headbar.vue'
import Sidebar from '../components/Sidebar.vue'
import OrderingScreen from '../components/OrderingScreen.vue'
import ItemList from '../components/ItemList.vue'

export default {
  name: 'Home',
  components: {
    Headbar,
    Sidebar,
    OrderingScreen,
    ItemList
  }
}

</script>

<style>
  #container {
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-columns: .2fr 1fr .4fr;
    grid-template-rows: .1fr 1fr;
    grid-template-areas: 
    "headbar headbar headbar"
    "sidebar itemList orderingScreen";
  }
  #headbar {
    grid-area: headbar;
  }
  #sidebar {
    grid-area: sidebar;
  }
  #item-list {
    grid-area: itemList;
  }
  #ordering-screen {
    grid-area: orderingScreen;
  }
  .home-element {
    border: 1px white solid;
  }
</style>