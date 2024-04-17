import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import LandmarkListView from '../views/LandmarkListView.vue';
import LandmarkDetailsView from '../views/LandmarkDetailView.vue';
import ItineraryListView from '../views/ItineraryListView.vue';
import ItineraryDetailsView from '../views/ItineraryDetailsView.vue';
import TourRouteView from '../views/TourRouteView.vue';
import AddItineraryDetailsView from '../views/AddItineraryDetailsView.vue';
import EditItineraryDetailsView from '../views/EditItineraryDetailsView.vue';
import UserRatingView from '../views/UserRatingView.vue';
import Downtown from '../views/DowntownView.vue';
import Kidsburgh from '../views/KidsburghView.vue';
import OffTheBeatenPath from '../views/OffTheBeatenPathView.vue';
import SteelCity from '../views/SteelCityHistoryView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [

  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/landmarks',
    name: 'landmarkList',
    component: LandmarkListView,
    meta: {
      requiredAuth: false
    }
  },
  {
    path: '/landmarks/:id',
    name: 'landmarkDetailsView',
    component: LandmarkDetailsView,
    meta: {
      requiredAuth: false
    }
  },
  {
    path: '/itineraries',
    name: 'itineraryList',
    component: ItineraryListView,
    meta: {
      requiredAuth: true
    }
  },
  {
    path: '/itineraries/:itineraryId',
    name: 'itineraryDetail',
    component: ItineraryDetailsView,
    meta: {
      requiredAuth: true
    }
  },
  {
    path: "/itineraries/new",
    name: "addItineraryDetailsView",
    component: AddItineraryDetailsView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/itineraries/:itineraryId/editor",
    name: "editItineraryDetailsView",
    component: EditItineraryDetailsView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/tour/:itineraryId',
    name: 'tourRoute',
    component: TourRouteView,
    meta: {
      requiredAuth: true
    }
  },
  {
    path: '/ratings',
    name: 'userRating',
    component: UserRatingView,
    meta: {
      requiredAuth: true
    }
  },
  {
    path: '/downtown',
    name: 'downtown',
    component: Downtown,
    meta: {
      requiredAuth: false
    }
  },
  {
    path: '/kidsburgh',
    name: 'kidsburgh',
    component: Kidsburgh,
    meta: {
      requiredAuth: false
    }
  },
  {
    path: '/offthebeatenpath',
    name: 'offTheBeatenPath',
    component: OffTheBeatenPath,
    meta: {
      requiredAuth: false
    }
  },
  {
    path: '/steelcity',
    name: 'steelcity',
    component: SteelCity,
    meta: {
      requiredAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return { name: "login" };
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
