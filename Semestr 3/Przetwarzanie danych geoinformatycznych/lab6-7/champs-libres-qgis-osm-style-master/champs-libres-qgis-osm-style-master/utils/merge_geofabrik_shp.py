# This small script is for batch merging shp from geofabrik into a single one
# It assumes ogr2ogr to be installed.


import subprocess

SHP_LIST = [
    'gis_osm_landuse_a_free_1.shp',
    'gis_osm_natural_a_free_1.shp',
    'gis_osm_natural_free_1.shp',
    'gis_osm_places_a_free_1.shp',
    'gis_osm_places_free_1.shp',
    'gis_osm_pofw_a_free_1.shp',
    'gis_osm_pofw_free_1.shp',
    'gis_osm_pois_a_free_1.shp',
    'gis_osm_pois_free_1.shp',
    'gis_osm_railways_free_1.shp',
    'gis_osm_roads_free_1.shp',
    'gis_osm_traffic_a_free_1.shp',
    'gis_osm_traffic_free_1.shp',
    'gis_osm_transport_a_free_1.shp',
    'gis_osm_transport_free_1.shp',
    'gis_osm_water_a_free_1.shp',
    'gis_osm_waterways_free_1.shp'
]

for shp in SHP_LIST:
    print(shp)
    for region in ['nord-pas-de-calais-latest-free.shp', 'limburg-latest-free.shp']:
        subprocess.call(
            'ogr2ogr -f "ESRI Shapefile" -update -append {} {} '
            .format('../map-style/shp/' + shp, '../map-style/shp/' + region + '/' + shp),
            shell=True
        )
