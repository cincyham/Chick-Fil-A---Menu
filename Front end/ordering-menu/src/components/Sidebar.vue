<template>
  <div id="sidebar">
    <div class="sidebar-element">
    <h2>Entree</h2>
    </div>
    <div class="sidebar-element">
    <h2>Sides</h2>
    </div>
    <div class="sidebar-element">
    <h2>Condiments</h2>
    </div>
    <div class="sidebar-element">
    <h2>Beverages</h2>
    </div>
    <div class="sidebar-element">
    <h2>Treats</h2>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
  #sidebar {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    padding-top: 25%;
    padding-bottom: 25%;
  }
  .sidebar-element {
    border-top: 1px brown solid;
    border-bottom: 1px brown solid;
    width: 100%;
    text-align: center;
  }
</style>