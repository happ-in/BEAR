<template>
<div id="nav">
    <body>
        <div data-role="page">
            <div data-role="header">
                <a href="#" data-icon="arrow-l" data-rel="back">이전</a>
                <h3>header</h3>
            </div>
        </div>
    </body>
</div>
  <!-- <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/recomendation">Recomendation</router-link>
  </div> -->
  <router-view />
</template>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  position: absolute;
  height: 30px;
  top: 13px;

  font-family: Noto Sans;
  font-style: normal;
  font-weight: normal;
  font-size: 20px;
  line-height: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
} */
</style>
