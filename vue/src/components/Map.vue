<!-- display the map of city with landmarks -->
<!-- test src="https://maps.googleapis.com/maps/api/staticmap?size=400x400&center=40.4396178,-79.94676969999999&zoom=13&path=weight:4%7Ccolor:red%7Cenc:sjyuFhr}fNnA[l@WZUZFLFEWCo@BoBQoBYgBWq@k@q@y@w@y@w@]a@Wg@O_AEq@Dg@No@L[h@cAV]hBqA`@YNSVs@Ni@?w@Ag@F}@b@oCXyAr@oCp@aCd@{BPoA?wAW}C?eCEmEAi@?LM^i@n@y@v@cAx@s@r@yA{GuByJuBeJq@}CYwAYcFw@sMcBmZ_OrCgRxD_@?YC{Bq@uEwAuGoBs@QWAGm@G?OAIEGcA&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI" -->

<template>
    <div id="distance">Distance: {{ distance }}</div>
    <img :src=mapURL alt="map route">
</template>

<script>


export default {

    props: ['thisRoute'],

    data() {
        return {
            
        }
    },

    computed: {

        distance() {
            return this.thisRoute.legs[0].distance.text;
        },
    
        latitude() {
            return this.thisRoute.legs[0].start_location.lat.toString();
        },

        longitude() {
            return this.thisRoute.legs[0].start_location.lng.toString();
        },

        polyline() {
            return this.thisRoute.overview_polyline.points;
        },

        mapURL() {
            const baseURL = 'https://maps.googleapis.com/maps/api/staticmap?size=400x400&center=';
            const lat = this.latitude;
            const comma = ',';
            const lng = this.longitude;
            const middleURL = '&zoom=11&path=weight:4%7Ccolor:red%7Cenc:';
            const line = this.polyline;
            const APIKey = '&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI';

            return (baseURL + lat + comma + lng + middleURL + line + APIKey);
        }
    }
}

</script>