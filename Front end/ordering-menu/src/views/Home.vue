<template>
  <div id="container">
    <headbar id="headbar" />
    <sidebar id="sidebar" />
    <item-list id="item-list" />
    <ordering-screen id="ordering-screen" />
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
    background-color: gray;
    grid-area: headbar;
  }
  #sidebar {
    background-color: blue;
    grid-area: sidebar;
  }
  #item-list {
    background-color: green;
    grid-area: itemList;
  }
  #ordering-screen {
    background-color: black;
    grid-area: orderingScreen;
  }
</style>